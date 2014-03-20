# API

basic API for Metalcon backend components

## Dependency

    <dependency>
      <groupId>de.metalcon</groupId>
      <artifactId>api</artifactId>
      <version>0.1.0</version>
    </dependency>

# Usage

The basic API is used in the API for your backend component.  

## Metalcon: Big picture

To let the client (middleware) send requests to your backend component there are three pojects involved:

1. API: basic Metalcon API defining response classes you can extend
2. `<component>API`: component API based upon the basic API that (can) has additional requests and responses.  
   Until this point, there is no technology for transmission set.
3. [middleware](../../../middleware): client with a dispatcher that uses your component API to send requests and interpret responses.
4. [zmqWorker](../../../zmqWorker): worker living in your component that parses incoming requests and your responses and sends them to the client via ZeroMQ. The worker uses the basic API.
5. `<component>`: your backend component used your API and the worker. It interprets incoming requests and delegates the responses to the worker.

## Requests

Basic request class `Request` that must be extended in order to use the worker.  
Requests do not have any contraints yet.

### ShutdownRequest

Send the `ShutdownRequest` to shutdown the transmission layer. (here: ZeroMQ Worker)

## Responses

Basic response class `Response` that must be extended in order to use the worker.  
Responses have a *status message* at least:
* success: signalizes that the request was correct
* error: signalizes an error concerning the request in any layer, see `ErrorResponse`

### SuccessResponse

Simple response signalizing success if no additional information is needed.  
Extend `SuccessResponse` and add fields if you need them.

### ErrorResponse

Basic error class `ErrorResponse` that signalizes an error.  
There are three types of errors, representing the layer in which the error occurred, defined in `ErrorResponse.ErrorType`.  
The *error type* and an *error message* describing the error must be set.  
There is an optional *solution* field.

**Error types**:
* PARSING_ERROR: error occurred when parsing request/response objects
* INTERNAL_SERVER_ERROR: error occurred in server due to internal reasons
* USAGE_ERROR: error occurred in server due to misuse by client

#### ParsingErrorResponse

Response signalizing a parsing error. Used by the worker that handles serialization/deserialization of requests and responses.  

#### InternalServerErrorResponse

Response signalizing an internal server error.

#### UsageErrorResponse

Response signalizing a misuse by the client.
