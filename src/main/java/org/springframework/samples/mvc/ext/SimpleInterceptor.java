package org.springframework.samples.mvc.ext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 简单的拦截器
 */
public class SimpleInterceptor implements HandlerInterceptor {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleInterceptor.class);

    /**
     * 执行Controller方法之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            StopWatch.get().start();
        }
        return true;
    }

    /**
     * 执行Controller方法之后, 展示View之前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav) throws Exception {
        if(mav != null){
            mav.addObject("base", request.getContextPath());
        }
    }

    /**
     * 展示View之后或出现异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            LOG.info("@Controller {}.{} execution cost {}ms", method.getBeanType(), method.getMethod().getName(), StopWatch.get().stop());
        }
    }
}
