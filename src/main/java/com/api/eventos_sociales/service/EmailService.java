package com.api.eventos_sociales.service;

import com.api.eventos_sociales.dto.EmailBody;

public interface EmailService {
    public boolean sendEmail(EmailBody emailBody);
}
