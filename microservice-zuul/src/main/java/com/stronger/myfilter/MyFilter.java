package com.stronger.myfilter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by wuqiang on 2017/11/11-0011.
 */
public class MyFilter  extends ZuulFilter{
    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * @return
     */
    @Override
    public String filterType() {
        /*
         pre：路由之前
         routing：路由之时
         post： 路由之后
         error：发送错误调用
         */
        return "pre";
    }

    /**
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     */
    @Override
    public Object run() {
        System.out.println("*************执行网关过滤器**********");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));

        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            System.out.println("In parameter: " + request.getRequestURI() + "  " + paraName + ": " + request.getParameter(paraName));
        }

       /* Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        System.out.println("ok");*/
        return null;
    }
}
