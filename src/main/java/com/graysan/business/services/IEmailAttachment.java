package com.graysan.business.services;

import com.graysan.business.dto.EmailDto;

public interface IEmailAttachment  {

    public EmailDto basicSendEmail(EmailDto emailDto);
    public EmailDto intermediaSendEmail(EmailDto emailDto);
}
