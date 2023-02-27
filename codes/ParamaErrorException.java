public�class�ParamaErrorException�extends�RuntimeException�{
 
����public�ParamaErrorException()�{
����}
 
����public�ParamaErrorException(String�message)�{
��������super(message);
����}
 
}

public�enum�ResultEnum�{
 
 �XITO (1000, "Solicitud exitosa"),
 PARAMETER_ERROR (1001, "�El par�metro de solicitud es incorrecto!"),
 UNKNOWN_ERROR (9999, "�Error desconocido!");
 
����private�Integer�code;
����private�String�message;
 
����ResultEnum(Integer�code,�String�message)�{
��������this.code�=�code;
��������this.message�=�message;
����}
 
����public�Integer�getCode()�{
��������return�code;
����}
 
����public�String�getMessage()�{
��������return�message;
����}
}