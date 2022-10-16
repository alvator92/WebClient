package webclient.backend.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import webclient.backend.common.StringConstant;
import webclient.backend.configuration.db.jpa.JpaConfig;
import webclient.backend.model.User;
import webclient.backend.service.UserService;
import webclient.backend.service.UserServiceImpl;

/**
 * Validator for {@link webclient.backend.model.User} class
 * Implements {@link Validator} interface
 *
 * @author Kabanets Vladislav
 * @version 1.0
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private JpaConfig jpaConfig;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", StringConstant.REQUIRED);
        if(user.getEmail().length() < 8 || user.getEmail().length() > 32) {
            errors.rejectValue("email", StringConstant.SIZE_USER_FORM);
        }

        if(jpaConfig.userService().findByEmail(user.getEmail())!=null){
            errors.rejectValue("email", StringConstant.USER_WITH_EMAIL_ALREADY_EXIST);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", StringConstant.REQUIRED);

        if(user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", StringConstant.SIZE_PASS_FORM);
        }

        if (!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", StringConstant.DIFFERENT_USERFORM_PASSWORD);
        }
    }
}
