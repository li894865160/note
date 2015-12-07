package com.note.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.note.web.entity.ResponseEntity;


public class BaseController {

    @Autowired
    protected AbstractMessageSource messageSource;

    /**
     * request
     */
    private HttpServletRequest request;

    /**
     * response
     */
    private HttpServletResponse response;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,
                             HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * @return the request
     */
    protected final HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @return the response
     */
    protected final HttpServletResponse getResponse() {
        return response;
    }

    /**
     * config model and view
     *
     * @param viewName
     * @return
     */
    protected final ModelAndView configModelAndView(String viewName) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        return mv;
    }

    /**
     * config model and view
     *
     * @param viewName
     * @param count
     * @param data
     * @return
     */
    protected final <T> ModelAndView configModelAndView(String viewName, final long count, List<T> data) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        mv.addObject("total", count);
        mv.addObject("data", data);
        return mv;
    }

    /**
     * config model and view
     *
     * @param viewName
     * @param modelName
     * @param model
     * @return
     */
    protected final ModelAndView configModelAndView(String viewName,
                                                    String modelName, Object model) {
        return new ModelAndView(viewName, modelName, model);
    }

    /**
     * config model and view
     *
     * @param viewName
     * @param modelName
     * @param model
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    protected final <T> ModelAndView configModelAndView(String viewName,
                                                        String modelName, Object model, final long count, List<T> data) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        mv.addObject("total", count);
        mv.addObject("rows", data);
        mv.addObject(modelName, model);
        return mv;
    }

    /**
     * config model and view
     *
     * @param viewName
     * @param map
     * @return
     */
    protected final ModelAndView configModelAndView(String viewName,
                                                    Map<String, ?> map) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        if (map != null) {
            mv.addAllObjects(map);
        }
        return mv;
    }

    /**
     * config model and view
     *
     * @param viewName
     * @param map
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    protected final <T> ModelAndView configModelAndView(String viewName, Map<String, ?> map, final long count, List<T> data) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        if (map != null) {
            mv.addAllObjects(map);
        }
        mv.addObject("total", count);
        mv.addObject("rows", data);
        return mv;
    }

    /**
     * 匹配反馈的错误信息
     *
     * @param result
     * @return
     */
    protected final String configFirstErrorMessage(BindingResult result) {
        if (result == null) {
            return null;
        }
        for (FieldError key : result.getFieldErrors()) {
            return key.getCode();
        }
        return null;
    }

    /**
     * 匹配反馈的错误信息, 仅存一条错误记录
     *
     * @param result
     * @param defaultKey
     * @return
     */
    protected final Map<String, String> configErrorMessage(BindingResult result,
                                                           String defaultKey) {
        if (result == null || defaultKey == null) {
            return new HashMap<String, String>();
        }
        Map<String, String> map = new HashMap<String, String>();
        for (FieldError key : result.getFieldErrors()) {
            map.put(defaultKey, key.getDefaultMessage());
            break;
        }
        return map;
    }

    /**
     * 数据返回
     *
     * @param entity
     * @param message
     * @param <T>
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected final <T> ResponseEntity responseEntity(final int code, final T entity, String message) {
        if (null != message && !"".equals(message)) {
            message = messageSource.getMessage(message, null, Locale.getDefault());
        }
        return new ResponseEntity(code, message, 0, null, entity);
    }

    /**
     * 数据返回
     *
     * @param code
     * @param message
     * @param count
     * @param data
     * @param <T>
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected final <T> ResponseEntity responseEntity(final int code, String message, final long count, List<T> data) {
        if (null != message && !"".equals(message)) {
            message = messageSource.getMessage(message, null, Locale.getDefault());
        }
        return new ResponseEntity(code, message, count, data, null);
    }
}