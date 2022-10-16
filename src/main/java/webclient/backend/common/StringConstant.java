package webclient.backend.common;

public class StringConstant {

  public static final String VALIDATION_ERROR_MESSAGE = "Неверный формат запроса.";

  public static final String CAPTCHA_CODE_ERROR_MESSAGE = "Код с картинки введен неверно.";

  public static final String USER_ALREADY_REGISTER_ERROR_MESSAGE = "Данный пользователь уже зарегистрирован.";

  public static final String USER_NAME_ERROR_MESSAGE = "Недопустимое имя пользователя.";

  public static final String DATA_BASE_ERROR_MESSAGE = "Ошибка при обращении к БД.";

  public static final String NOT_ALLOWED_IMAGE_TYPE_ERROR_MESSAGE = "Недопустимый формат изображения.";

  public static final String POST_NOT_FOUND = "Пост не найден.";

  public static final String USER_NOT_FOUND = "Пользователь не найден.";

  public static final String USER_WITH_EMAIL_ALREADY_EXIST = "Пользователь с указанным email уже зарегистрирован.";

  public static final String REQUIRED = "This field is Required.";

  public static final String SIZE_USER_FORM = "Имя пользователя должно быть от 8 до 32 символов";

  public static final String SIZE_PASS_FORM = "Пароль пользователя должен быть более 8 символов и менее 32 символов.";

  public static final String WRONG_PASS = "Пароль не верный";

  public static final String LOGOUT = "Выход выполнен успешно!";

  public static final String WRONG_EMAIL_PASS = "Логин или Пароль не верный";
  public static final String DIFFERENT_USERFORM_PASSWORD = "Пароли не совпадают";

  private StringConstant(){}
}
