package de.metalcon.api.responses.errors;

/**
 * response: request failed due to internal server error
 * 
 * @author sebschlicht
 * 
 */
public class InternalServerErrorResponse extends ErrorResponse {

    private static final long serialVersionUID = -483593465489415659L;

    /**
     * create internal server error response
     * 
     * @param errorMessage
     *            error message describing the error
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public InternalServerErrorResponse(
            String errorMessage,
            String solution) {
        super(ErrorType.INTERNAL_SERVER_ERROR, errorMessage, solution);
    }

    /**
     * create internal server error response
     * 
     * @param e
     *            exception to get the error message from
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public InternalServerErrorResponse(
            Exception e,
            String solution) {
        super(ErrorType.INTERNAL_SERVER_ERROR, e, solution);
    }

}
