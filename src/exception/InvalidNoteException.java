package exception;

@SuppressWarnings("serial")
public class InvalidNoteException extends Exception
{
	public InvalidNoteException()
	{
		
	}

	/**
	 * @param message error message specific to cause of error.
	 */
	public InvalidNoteException(String message)
	{
		super(message);
	}
}
