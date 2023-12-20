DELETE FROM User;
INSERT INTO User (firstName, lastName, email, phone, password, creationTime, updateTime) VALUES
                                                                                             ('John', 'Doe', 'john.doe@example.com', '1234567890', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                             ('Jane', 'Doe', 'jane.doe@example.com', '0987654321', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                             ('Robert', 'Smith', 'robert.smith@example.com', '1122334455', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                             ('Emily', 'Johnson', 'emily.johnson@example.com', '2233445566', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
                                                                                             ('Mike', 'Williams', 'mike.williams@example.com', '3344556677', 'password123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);