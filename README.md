# consumer-driven-contracts-example

Provides a simple example of how Pact can be used to use Consumer Driver
Contracts.

## Building and running

1.  Start all required infrastructure services (database and Pact broker):

    ```sh
    cd infra
    docker-compose up -d
    cd ..
    ```
2.  Run consumer tests and publish the pact to the broker:

    ```sh
    cd consumers/check-cart-batch
    mvn clean test -Ppublish-pact
    cd ../..
    ```

3.  Run provider tests using the published pact from the consumer:

    ```sh
    cd providers/cart-service
    mvn clean verify
    cd ../..
    ```

## Pact broker

The broker will be running on [http://localhost:8085](http://localhost:8085).

After running step 2, it will contain one pact. 
