package com.sancom.careerday.Controllers;

import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected ResponseEntity sendResponse(boolean status,String message){
        if(!StringUtils.isEmpty(message))
            message=message.replaceAll("\\s{2,}"," ");
        final String res = ("{\"success\" : "+status+", \"msg\" :\""+message+"\"}");
        return new ResponseEntity(res, HttpStatus.OK);

    }
    protected LocalDate toLocalDate(String date){
        LocalDateTime dateTime = LocalDateTime.parse(date);
        return LocalDate.from(dateTime);
    }
    protected ModelAndView redirectToPage(String page){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName(page);
        return modelAndView;
    }
}
