# quiz-service-sboot
This app would demonstrate how a "Quiz APIs" would look like.


Design and Develop APIs for a Quiz application. Below contract you need to follow for the evaluation for the Social Feeds model in your application. Field names in the request object (which will be sent to your application), and field names in the response object (which will be received from your application) will be specified exactly as expected.

## **Fetch a Quiz info**

Get the quiz information for the given ID
*GET* /api/quiz/:quizId

Response Code 200 : Expected response should be of the form

```json
{
    "id": , ?------------ integer
    "name": "", ?------------ string 
    "description": "", ?------------ string
}
```

Response Code 404 (failure) : Expected response should be of the form:

```json
{} ?--------- empty body
```

## **Create a Quiz**

Add a quiz entry to the platform
*POST* /api/quiz/

The expected request should be of the form

```json
{
    "name": "", ?--------- string
    "description": "" ?--------- string
}
```

Response Code 200 : Expected response should be of the form containing following fields

```json
{
    "id": , ?------------ integer
    "name": "", ?------------ string 
    "description": "", ?------------ string
}
```

Response Code 400 (failure) : Expected response should be of the form:

```json
{
    "status": "failure", ?--------- string
    "reason": "explanation" ?--------- string (explanation can be any message)
}
```

## **Delete a Quiz**

Delete a quiz entry from the platform
*DELETE* /api/quiz/:quizId


Response Code 200 : No Body


Response Code 404 (failure) : Expected response should be of the form:

```json
{
    "status": "failure", ?--------- string
    "reason": "explanation" ?--------- string (explanation can be any message)
}
```

## **Create a Question**

Create a Question for the quiz
*POST* /api/questions/

The expected request should be of the form

```json
{
    "name": "q1", ?--------- string
    "options": "o1,o2,o3,o4", ?--------- string (comma-separated options)         
    "correct_option": 3, ?--------- integer     
    "quiz_id": 1, ?--------- integer             
    "points": 80 ?--------- integer           
}
```

Response Code 200 : Expected response should be of the form containing following fields

```json
{
    "id": 1, ?--------- integer
    "name": "q1", ?--------- string
    "options": "o1,o2,o3,o4", ?--------- string (comma-separated options)         
    "correct_option": 3, ?--------- integer     
    "quiz_id": 1, ?--------- integer             
    "points": 80 ?--------- integer           
}
```

Response code 400 (failure) : Expected response should be of the form:

```json
{
    "status":"failure",
    "reason":"explanation" ?--------- explanation can be any message
}
```


## **Fetch a Question**

Get the Question information
*GET* /api/questions/:questionId

Response Code 200 : Expected response should be of the form

```json
{
    "id": 1, ?--------- integer
    "name": "q1", ?--------- string
    "options": "o1,o2,o3,o4", ?--------- string (comma-separated options)         
    "correct_option": 3, ?--------- integer     
    "quiz_id": 1, ?--------- integer             
    "points": 80 ?--------- integer           
}
```

Response Code 404 (failure) : Expected response should be of the form:

```json
{}
```

Response Code 400 (failure) : Expected response should be of the form:

```json
{
    "status":"failure",
    "reason":"explanation" ?--------- explanation can be any message
}
```