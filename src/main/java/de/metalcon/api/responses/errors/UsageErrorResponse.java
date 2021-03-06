package de.metalcon.api.responses.errors;

/**
 * response: request failed due to misuse of server API
 * 
 * @author sebschlicht
 * 
 */
public class UsageErrorResponse extends ErrorResponse {

    private static final long serialVersionUID = -1939869975671752450L;

    /**
     * create usage error response
     * 
     * @param errorMessage
     *            error message describing the error
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public UsageErrorResponse(
            String errorMessage,
            String solution) {
        super(ErrorType.USAGE_ERROR, errorMessage, solution);
    }

    /**
     * create usage error response
     * 
     * @param e
     *            exception to get the error message from
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public UsageErrorResponse(
            Exception e,
            String solution) {
        super(ErrorType.USAGE_ERROR, e, solution);
    }

}
