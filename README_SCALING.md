# Backend Scaling

How I would scale the backend from **5 RPS → 50 RPS → 500 RPS**.

## 5 RPS

Keep the setup simple.

* Single Spring Boot instance and database.
* Docker for local setup.
* JPA with SQL/native queries where needed.
* `Controller → Service → Repository` structure.
* No caching or messaging needed.
* Keep CPU and memory requirements low.
* Add proper application logs with **operation, method name and a meaningful message**. Avoid logging sensitive data or full response payloads.
* Basic health checks and unit tests.
* Add database indexes only when needed.
* Load test to establish a baseline.

## 50 RPS

Start scaling based on actual usage.

* Increase CPU/memory or run multiple backend instances if required.
* Add a load balancer when running multiple instances.
* Keep the application stateless.
* Tune database connection pool.
* Add global exception handling and request validation.
* Add an index on `COUNTRY` if it is frequently used for filtering.
* Consider Redis if repeated reads are putting load on the database.
* Use **Splunk** for centralized logs and monitoring.
* Add request tracing/correlation IDs so requests can be followed across services.
* Monitor API response time and errors.
* Setup CI with unit tests, Sonar and dependency/vulnerability checks.
* Add authentication/authorization and strict CORS as required.

## 500 RPS

At this point, focus on horizontal scaling and protecting the database and downstream services.

* Multiple Spring Boot instances behind a load balancer.
* Cloud auto-scaling based on CPU/metrics.
* API Gateway with rate limiting.
* Timeouts and circuit breakers for downstream services.
* Redis for frequently accessed data where caching is useful.
* Kafka/message queue for work that can be processed asynchronously.
* Optimize database queries and add composite/covering indexes where needed.
* Consider read replicas for read-heavy workloads.
* Keep JPA for normal operations; consider JOOQ for complex SQL.
* Maintain OpenAPI contracts for all APIs.
* Strong authentication/authorization and proper token validation.
* Use **Dynatrace** for deeper APM, distributed tracing and infrastructure monitoring.
* Monitor p95/p99 latency, errors, CPU, memory and DB usage.
* Create a common Spring Boot library for shared validators/utilities once multiple services need them.

## Load Testing

For each stage, validate the target RPS with load tests and monitor:

* RPS
* p95/p99 latency
* Error rate
* CPU/memory
* Database connections and latency

The main approach is to **measure first, find the bottleneck, and then scale the part that needs it**.
