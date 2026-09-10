# Traffic Backend

Backend service for the Traffic application.

The project is built with Spring Boot and Maven. Docker is used to run the services required by the application.

## Prerequisites

Before running the application, make sure **Docker** is installed and running on your machine.

You can download Docker Desktop here:

[Docker Desktop](https://www.docker.com/products/docker-desktop/?utm_source=chatgpt.com)

You can check that Docker is installed by running:

```bash
docker --version
docker compose version
```

## Getting Started

Clone the repository:

```bash
git clone https://github.com/burningpriest/traffic-backend.git
cd traffic-backend
```

Make sure Docker Desktop is running before continuing.

The project includes a `start.sh` script to start the backend and its required services.

### macOS / Linux

Run:

```bash
chmod +x start.sh
./start.sh
```

### Windows

On Windows, `start.sh` needs to be run from a Bash environment.

The easiest option is **Git Bash**.

1. Install Git for Windows if you don't already have it.
2. Start Docker Desktop.
3. Open Git Bash.
4. Navigate to the project directory.
5. Run:

```bash
./start.sh
```

If needed, you can also run:

```bash
bash start.sh
```

WSL can also be used instead of Git Bash.

## Running the Application

Once `start.sh` has finished, the backend and required services should be running.

The backend can then be accessed at the configured application port.

## Stopping the Application

To stop the Docker services:

```bash
docker compose down
```

## Troubleshooting

### Docker is not running

If you see an error such as:

```text
Cannot connect to the Docker daemon
```

make sure Docker Desktop is running and try again.

### Permission denied

On macOS or Linux, run:

```bash
chmod +x start.sh
```

and then:

```bash
./start.sh
```

### Windows

`start.sh` cannot be run directly from Command Prompt. Use **Git Bash** or **WSL** instead.