# trustbox
This project is just a simple proxy server to a Keycloak server, nothing more. It is used as a jump box since [pnc-build-agent](https://github.com/project-ncl/pnc-build-agent/) runs in a hermetic environment which firewalls outgoing connections.

Our Keycloak server's DNS may return multiple IP addresses that can change at any moment. This doesn't work well with our firewall which expects a specific IP address to allow-list instead.

The solution we thought of is to create this jumpbox, with a static IP address that will never change, as a proxy to the Keycloak server.

The client id and client secret are not logged, or stored in a temporary or
persistent store for security reasons.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.
