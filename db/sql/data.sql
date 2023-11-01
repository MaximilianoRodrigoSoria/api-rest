INSERT INTO history (endpoint, request, response, status, method, timestamp, success)
VALUES
    ('/api/resource1', 'Request 1', 'Response 1', '200', 'GET', '2023-01-01 10:00:00', true),
    ('/api/resource2', 'Request 2', 'Response 2', '404', 'POST', '2023-01-02 15:30:00', false),
    ('/api/resource1', 'Request 3', 'Response 3', '200', 'GET', '2023-01-03 08:45:00', true);

