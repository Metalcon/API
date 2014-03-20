package de.metalcon.api.responses.errors;


/**
 * response: request failed due to parsing error in worker
 * 
 * @author sebschlicht
 * 
 */
public class ParsingErrorResponse extends ErrorResponse {

    private static final long serialVersionUID = -71565193363368684L;

    /**
     * create parsing error response
     * 
     * @param errorMessage
     *            error message describing the error
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public ParsingErrorResponse(
            String errorMessage,
            String solution) {
        super(ErrorType.PARSING_ERROR, errorMessage, solution);
    }

    /**
     * create parsing error response
     * 
     * @param e
     *            exception to get the error message from
     * @param solution
     *            solution suggestion (may be <b>null</b>)
     */
    public ParsingErrorResponse(
            Exception e,
            String solution) {
        super(ErrorType.PARSING_ERROR, e, solution);
    }

}
