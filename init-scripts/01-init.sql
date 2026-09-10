-- Create traffic_data table
CREATE TABLE IF NOT EXISTS traffic_data (
    id BIGSERIAL PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    year INTEGER NOT NULL,
    vehicle_type VARCHAR(50) NOT NULL,
    traffic_count BIGINT NOT NULL
);
