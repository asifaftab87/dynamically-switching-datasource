package org.two.data.source.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.two.data.source.constant.BranchEnum;

@Component
public class DataSourceInterceptor extends HandlerInterceptorAdapter {

	Logger log = LoggerFactory.getLogger(DataSourceInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String methodType = request.getMethod();
		
		log.info("preHandle: "+ methodType);
		
		
		if (methodType.equalsIgnoreCase("get"))
			BranchContextHolder.setBranchContext(BranchEnum.READ_ONLY);
		else
			BranchContextHolder.setBranchContext(BranchEnum.WRITE_ONLY);
		return super.preHandle(request, response, handler);
	}
	
}
