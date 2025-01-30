document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
    const nameInput = document.getElementById("name");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const phoneInput = document.getElementById("phoneNumber");
    const aboutInput = document.getElementById("about");

    // Function to display error messages
    function showError(input, message) {
        const formControl = input.parentElement;
        const errorMessage = formControl.querySelector(".error-message");

        if (!errorMessage) {
            const errorElement = document.createElement("p");
            errorElement.className = "error-message text-red-500 text-sm mt-1";
            errorElement.innerText = message;
            formControl.appendChild(errorElement);
        } else {
            errorMessage.innerText = message;
        }
    }

    // Function to clear error messages
    function clearError(input) {
        const formControl = input.parentElement;
        const errorMessage = formControl.querySelector(".error-message");

        if (errorMessage) {
            errorMessage.remove();
        }
    }

    // Function to validate name
    function validateName() {
        const nameValue = nameInput.value.trim();
        if (nameValue === "") {
            showError(nameInput, "Name is required.");
            return false;
        } else if (nameValue.length < 3) {
            showError(nameInput, "Name must be at least 3 characters.");
            return false;
        } else {
            clearError(nameInput);
            return true;
        }
    }

    // Function to validate email
    function validateEmail() {
        const emailValue = emailInput.value.trim();
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (emailValue === "") {
            showError(emailInput, "Email is required.");
            return false;
        } else if (!emailRegex.test(emailValue)) {
            showError(emailInput, "Please enter a valid email address.");
            return false;
        } else {
            clearError(emailInput);
            return true;
        }
    }

    // Function to validate password
    function validatePassword() {
        const passwordValue = passwordInput.value.trim();
        if (passwordValue === "") {
            showError(passwordInput, "Password is required.");
            return false;
        } else if (passwordValue.length < 6) {
            showError(passwordInput, "Password must be at least 6 characters.");
            return false;
        } else {
            clearError(passwordInput);
            return true;
        }
    }

    // Function to validate phone number
    function validatePhone() {
        const phoneValue = phoneInput.value.trim();
        const phoneRegex = /^\+?\d{10,15}$/;

        if (phoneValue === "") {
            showError(phoneInput, "Phone number is required.");
            return false;
        } else if (!phoneRegex.test(phoneValue)) {
            showError(phoneInput, "Please enter a valid phone number.");
            return false;
        } else {
            clearError(phoneInput);
            return true;
        }
    }

    // Function to validate about section
    function validateAbout() {
        const aboutValue = aboutInput.value.trim();
        if (aboutValue === "") {
            showError(aboutInput, "About section is required.");
            return false;
        } else if (aboutValue.length < 10) {
            showError(aboutInput, "About section must be at least 10 characters.");
            return false;
        } else {
            clearError(aboutInput);
            return true;
        }
    }

    // Event listeners for real-time validation
    nameInput.addEventListener("input", validateName);
    emailInput.addEventListener("input", validateEmail);
    passwordInput.addEventListener("input", validatePassword);
    phoneInput.addEventListener("input", validatePhone);
    aboutInput.addEventListener("input", validateAbout);

    // Form submission validation
    form.addEventListener("submit", function (e) {
        e.preventDefault();

        const isNameValid = validateName();
        const isEmailValid = validateEmail();
        const isPasswordValid = validatePassword();
        const isPhoneValid = validatePhone();
        const isAboutValid = validateAbout();

        if (isNameValid && isEmailValid && isPasswordValid && isPhoneValid && isAboutValid) {
            form.submit();
        }
    });
});