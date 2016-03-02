CREATE KEYSPACE dylanmyretail
  WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 2 } AND DURABLE_WRITES = true;