Feature: Some api endpoints

  Scenario: GET endpoint

    Given the request method is 'GET'
    Given the request has header 'Content-Type'='application/json'
    When the request is sent to '/api/234'
    Then the server responds with status code '200'
    Then the response body matches '{"name":"john","status":"active"}'
    Then the response has header 'Content-Type'='application/json'

    Then the body size is '33'

  Scenario: GET endpoint, no good

    Given the request method is 'GET'
    Given the request has header 'Content-Type'='application/json'
    When the request is sent to '/api/2352646'
    Then the server responds with status code '500'
    Then the response has header 'Content-Type'='application/json'

  Scenario: POST endpoint

    Given the request method is 'POST'
    Given the request has header 'Content-Type'='application/json'
    Given the request body is '{"name":"eve","status":"new"}'
    When the request is sent to '/api'
    Then the server responds with status code '201'
    Then the response body matches '{"id":123,"name":"eve","status":"new"}'
    Then the response has header 'Content-Type'='application/json'

  Scenario: POST endpoint, no good

    Given the request method is 'POST'
    Given the request has header 'Content-Type'='application/json'
    Given the request body is '{"name":"steve","status":"new"}'
    When the request is sent to '/api'
    Then the server responds with status code '500'
    Then the response has header 'Content-Type'='application/json'
