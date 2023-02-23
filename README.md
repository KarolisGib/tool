# Installation

Checkout project from `https://github.com/KarolisGib/tool`.

To run the project do:

```bash
$ mvn clean package
$ java -jar target/tool.jar
```

You need to have Java 19 installed on your computer.

# Testing

To upload the file, simply do:

```bash
curl --location 'http://localhost:8080/mapping/post/upload-file' \
--form 'file=@"people.csv"'
```

To get employees, simply do:

```bash
curl 'http://localhost:8080/mapping/get/employee/all'
```