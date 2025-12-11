package com.example.oms.demo;

public class NotificationService {

    private final EmailService emailService;
    private final UserRepository userRepository;

    public NotificationService(EmailService emailService, UserRepository userRepository) {
        this.emailService = emailService;
        this.userRepository = userRepository;
    }

    public void notifyUser(int userId) {
        User user = userRepository.findById(userId);

        if (user == null) {
            throw new IllegalArgumentException("User not found: " + userId);
        }

        emailService.sendEmail(user.getEmail());
    }
}


