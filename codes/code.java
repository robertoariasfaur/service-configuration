@Address   
    private String address;

@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
  private String ipAddress;
------------------------------------------------------

@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message = "Enter valid date.")
    private Date birthDate;
----------------------------------------------------------------------
 @Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
    private String phNum;

@CreditCardNumber(message="Enter valid card number.")
    private String card;
------------------------------------------------------------------
@Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
private String password;

@Pattern(regexp = "^[a-zA-Z0-9]{6,10}$")
private String password;

-------------------------------------------------
@AssertTrue //@AssertTrue – Checks that the annotated element is true.
private boolean isWorking;

@AssertFalse // @AssertFalse – Checks that the annotated element is false.
private boolean isStudent;
------------------------------------------------
 @NegativeOrZero – Checks if the given element is smaller than or equal to 0.
 @Negative – Checks if the element is strictly smaller than 0.

13. @Positive – Checks if the element is strictly greater than 0.

14. @PositiveOrZero – Checks if the given element is greater than or equal to 0.