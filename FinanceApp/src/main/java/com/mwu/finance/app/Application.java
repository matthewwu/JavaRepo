package com.mwu.finance.app;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mwu.finance.model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import javax.management.Query;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mwu on 6/8/15.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    public static final String DB_NAME = "journaldev";
    public static final String PORT_COLLECTION = "Portfolio";
    public static final String MONGO_HOST = "localhost";
    public static final int MONGO_PORT = 27017;

    @Override
    public void run(String... strings) throws Exception {
        Stock stock = YahooFinance.get("INTC");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -1); // from 1 year ago

        Stock google = YahooFinance.get("GOOG");
        List<HistoricalQuote> googleHistQuotes = google.getHistory(from, to, Interval.DAILY);

        System.out.println("----------------------------");
        System.out.println(googleHistQuotes.size());
    }

    public static void main(String[] args)
    {
        SparkTest();

        ApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
        Portfolio p = new Portfolio();
        p.setPid(104);
        p.setId(2);
        mongoOperation.save(p,PORT_COLLECTION);

        Boolean exist = mongoOperation.collectionExists(PORT_COLLECTION);
        List<Portfolio> allPs = mongoOperation.findAll(Portfolio.class,PORT_COLLECTION);
        for(Portfolio pitem : allPs)
        {
            System.out.println(pitem.getId());
        }

        MongoClient mc = new MongoClient();
        //SpringApplication.run(Application.class, args);
    }

    private static void SparkTest()
    {
        String logFile = "/Users/mwu/DevRepo/spark-1.3.1-bin-hadoop2.6/README.md";
        SparkConf conf = new SparkConf().setMaster("local").setAppName("Matt Spark App");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> logData = sc.textFile(logFile);

        JavaRDD<String> containA = logData.filter(
                new Function<String, Boolean>() {
                    @Override
                    public Boolean call(String s) throws Exception {
                        return s.contains("a");
                    }
                }
        );

        long numAs = containA.count();

        long numBs = logData.filter(new Function<String, Boolean>() {
            public Boolean call(String s) { return s.contains("b"); }
        }).count();



        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);
    }


}
