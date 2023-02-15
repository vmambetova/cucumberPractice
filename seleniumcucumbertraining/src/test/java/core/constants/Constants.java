package core.constants;

import lombok.Data;

@Data
public class Constants {

        private String accCreatedMessage = "Your Account Has Been Created!";
        private String passwordMessage = "Password must be between 4 and 20 characters!";
        private String privacyPolicyWarningMessage = "Warning: You must agree to the Privacy Policy!";
        private String firstNameMessage = "First Name must be between 1 and 32 characters!";
        private String lastNameMessage = "Last Name must be between 1 and 32 characters!";
        private String emailMessage = "E-Mail Address does not appear to be valid!";
        private String alreadyCreatedMessage = "Warning: E-Mail Address is already registered!";
        private String telephoneMessage = "Telephone must be between 3 and 32 characters!";
        private String passwordConfirmMessage = "Password confirmation does not match password!";
        private String myAccountPage = "https://www.demoshop24.com/index.php?route=account/account";
        private String homePage = "http://www.demoshop24.com/index.php?route=common/home";
}