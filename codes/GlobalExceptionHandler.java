import�club.mydlq.valid.entity.ResponseResult;
import�club.mydlq.valid.enums.ResultEnum;
import�club.mydlq.valid.exception.ParamaErrorException;
import�lombok.extern.slf4j.Slf4j;
import�org.springframework.http.HttpStatus;
import�org.springframework.http.converter.HttpMessageNotReadableException;
import�org.springframework.util.StringUtils;
import�org.springframework.validation.BindingResult;
import�org.springframework.validation.FieldError;
import�org.springframework.validation.ObjectError;
import�org.springframework.web.bind.MethodArgumentNotValidException;
import�org.springframework.web.bind.MissingServletRequestParameterException;
import�org.springframework.web.bind.annotation.ExceptionHandler;
import�org.springframework.web.bind.annotation.ResponseStatus;
import�org.springframework.web.bind.annotation.RestControllerAdvice;
import�java.util.List;
 
@Slf4j
@RestControllerAdvice("club.mydlq.valid")
public�class�GlobalExceptionHandler�{
 
����/**
 Ignorar el controlador de excepciones de par�metros
�����*
 Ignorar excepciones de par�metros * @param e
�����*�@return�ResponseResult
�����*/
����@ResponseStatus(HttpStatus.BAD_REQUEST)
����@ExceptionHandler(MissingServletRequestParameterException.class)
����public�ResponseResult�parameterMissingExceptionHandler(MissingServletRequestParameterException�e)�{
��������log.error("",�e);
 Devuelve nuevo ResponseResult (ResultEnum.PARAMETER_ERROR.getCode (), "par�metro de solicitud" + e.getParameterName () + "no puede estar vac�o");
����}
 
����/**
 Falta el controlador de excepciones del cuerpo de la solicitud
�����*
 * @Param e Falta la excepci�n del cuerpo de la solicitud
�����*�@return�ResponseResult
�����*/
����@ResponseStatus(HttpStatus.BAD_REQUEST)
����@ExceptionHandler(HttpMessageNotReadableException.class)
����public�ResponseResult�parameterBodyMissingExceptionHandler(HttpMessageNotReadableException�e)�{
��������log.error("",�e);
 Devuelve nuevo ResponseResult (ResultEnum.PARAMETER_ERROR.getCode (), "El cuerpo del par�metro no puede estar vac�o");
����}
 
����/**
 Controlador de excepciones de validaci�n de par�metros
�����*
 Anormalidad de verificaci�n de par�metros * @param e
�����*�@return�ResponseInfo
�����*/
����@ResponseStatus(HttpStatus.BAD_REQUEST)
����@ExceptionHandler(MethodArgumentNotValidException.class)
����public�ResponseResult�parameterExceptionHandler(MethodArgumentNotValidException�e)�{
��������log.error("",�e);
 Obtener informaci�n anormal
��������BindingResult�exceptions�=�e.getBindingResult();
 Determine si hay informaci�n de error en la excepci�n, si existe, use el mensaje en la excepci�n, de lo contrario use el mensaje predeterminado
��������if�(exceptions.hasErrors())�{
������������List<ObjectError>�errors�=�exceptions.getAllErrors();
������������if�(!errors.isEmpty())�{
 Todos los par�metros de error se enumeran aqu�. Seg�n la l�gica normal, solo se requiere el primer error
����������������FieldError�fieldError�=�(FieldError)�errors.get(0);
����������������return�new�ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(),�fieldError.getDefaultMessage());
������������}
��������}
��������return�new�ResponseResult(ResultEnum.PARAMETER_ERROR);
����}
 
����/**
 Controlador de excepciones para errores de par�metros personalizados
�����*
 * @Param e par�metros personalizados
�����*�@return�ResponseInfo
�����*/
����@ResponseStatus(HttpStatus.BAD_REQUEST)
����@ExceptionHandler({ParamaErrorException.class})
����public�ResponseResult�paramExceptionHandler(ParamaErrorException�e)�{
��������log.error("",�e);
 Determine si hay informaci�n de error en la excepci�n, si existe, use el mensaje en la excepci�n, de lo contrario use el mensaje predeterminado
��������if�(!StringUtils.isEmpty(e.getMessage()))�{
������������return�new�ResponseResult(ResultEnum.PARAMETER_ERROR.getCode(),�e.getMessage());
��������}
��������return�new�ResponseResult(ResultEnum.PARAMETER_ERROR);
����}
 
}














@RestControllerAdvice ("club.mydlq.valid") // Especifique el nombre del paquete para el manejo de excepciones
public�class�GlobalExceptionHandler�{
 
 @ResponseStatus (HttpStatus.BAD_REQUEST) // Establezca el c�digo de estado en 400
����@ExceptionHandler({MethodArgumentNotValidException.class})
����public�String�paramExceptionHandler(MethodArgumentNotValidException�e)�{
��������BindingResult�exceptions�=�e.getBindingResult();
 Determine si hay un mensaje de error en la excepci�n; si existe, use el mensaje en la excepci�n; de lo contrario, use el mensaje predeterminado
��������if�(exceptions.hasErrors())�{
������������List<ObjectError>�errors�=�exceptions.getAllErrors();
������������if�(!errors.isEmpty())�{
 Todos los par�metros de error se enumeran aqu� De acuerdo con la l�gica normal, solo se requiere el primer error.
����������������FieldError�fieldError�=�(FieldError)�errors.get(0);
����������������return�fieldError.getDefaultMessage();
������������}
��������}
 return "Error de par�metro de solicitud";
����}
 
}