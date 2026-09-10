#!/bin/bash

set -e

NETWORK_NAME="traffic-network"

echo "======================================"
echo " Starting Traffic Backend"
echo "======================================"

# Create shared Docker network if it doesn't exist
if ! docker network inspect "$NETWORK_NAME" >/dev/null 2>&1; then
    echo "Creating Docker network: $NETWORK_NAME"
    docker network create "$NETWORK_NAME"
else
    echo "Docker network already exists: $NETWORK_NAME"
fi

echo ""
echo "Starting PostgreSQL and Spring Boot..."
docker compose up -d --build

echo ""
echo "======================================"
echo " Traffic Backend Started"
echo "======================================"
echo ""
echo "API:      http://localhost:8080"
echo "Database: PostgreSQL (Docker)"
echo ""
echo "Run:"
echo "  docker compose logs -f backend"
echo ""