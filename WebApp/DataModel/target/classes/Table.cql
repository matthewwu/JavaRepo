CREATE KEYSPACE LinkStorage
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


USE LinkStorage;


CREATE TABLE LinkResult_From (
from_id bigint,
score decimal,
from_db ascii,
to_id bigint,
to_db ascii,
from_source_id bigint,
cdate timestamp,
 PRIMARY KEY (from_id, score)
)
WITH CLUSTERING ORDER BY (score DESC);