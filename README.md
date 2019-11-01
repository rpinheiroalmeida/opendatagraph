# opendatagraph

To run the application execute the follows commands:

## Requitement:
It's necessary have Docker installed.


## Starting a neo4j server

The command bellow download a Neo4J docker image and start in the port 7687.

```
make run-neo4j
```


To see the Neo4J Browser, access the URL:

* http://localhost:7474/browser/

## Starting the application

To start the application, just run:

```
make run-application
```

This command start the Spring Boot Application in the port 8080.

The application is accessible in the url:

* http://localhost:8080

# Important Endpoints:

## To generate the Json with data execute a POST for the url:

* http://localhost:8080/generate-json-file?size=5

The variable `size`  is the array's size that will be generated.

For example:

```
curl -i -X POST -H "Content-Type:application/json" -d '{}' http://localhost:8080/generate-json-file\?size\=1
```

## To save the data in the Neo4J database, execute a POST command for the url:

* http://localhost:8080/create

For example:

```
curl -i -X POST http://localhost:8080/create
```

 
