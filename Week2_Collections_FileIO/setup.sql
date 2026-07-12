-- Drop the table if it already exists to avoid errors
DROP TABLE IF EXISTS Employees;

-- Create a clean, straightforward Employee table
CREATE TABLE Employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    salary NUMERIC(10, 2) NOT NULL
);

-- Insert dummy data to verify it works instantly
INSERT INTO Employees (name, role, salary) VALUES
('Sanjana', 'FSE Intern', 45000.00),
('Prajwal', 'Backend Developer', 60000.00);