# API

basic API for Metalcon backend components

## Dependency

    <dependency>
      <groupId>de.metalcon</groupId>
      <artifactId>api</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>

# Usage

The basic API is used in the API for your backend component.  
The [ZMQ Worker](../../../zmqWorker) does also use the basic API for parsing errors.

## Requests

There is no basic request class, but a `ShutdownRequest` for the worker.  
Keep in mind that requests must be serializable and therefore implement the proper interface.

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
