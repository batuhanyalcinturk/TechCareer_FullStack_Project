package com.graysan.business.services;

import com.graysan.business.dto.EmailDto;

import java.util.List;

// D: Dto
// E: Entity
public interface IEmailServices<D, E> extends  IEmailAttachment{

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // LIST
    public List<D> emailServiceList();

    ///////////////////////////////////////////////

    // OVERRIDE
    @Override
    EmailDto basicSendEmail(EmailDto emailDto);

    @Override
    EmailDto intermediaSendEmail(EmailDto emailDto);
}
