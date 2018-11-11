# gitRepository
一、整合Servlet
1、通过注解扫描完成Servlet组件的注册
1.1、编写Servlet
/**
 * SpringBoot整合Servlet方式一
 *
 *<servlet>
 *	<servlet-name>FirstServlet</servelt-name>
 *	<servlet-class>com.yunlovec.servlet.FirstServlet</servlet-class>
 *</servlet>
 *
 *<servlet-mapping>
 *	<servlet-name>FirstServlet</servlet-name>
 *	<url-pattern>/first</url-pattern>
 *</servlt-mapping>
 *
 */
@WebServlet(name="FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FirstServlet-----");
	}
	
}

1.2、编写启动类
/**
 * SpringBoot整合Servlet方式一 
 *
 */
@SpringBootApplication
@ServletComponentScan//在springBoot启动时扫描@WebServlet，并将该类实例化
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}

2、通过方法完成Servlet组件的注册
2.1、编写Servlet
/**
 * SpringBoot整合Servlet方式二 
 *
 */
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SecondServlet------");
	}
	
}


2.2、编写启动类
/**
 * 
 * SpringBoot整合Servlet方式二
 */
@SpringBootApplication
public class App2 {
	public static void main(String[] args) {
		SpringApplication.run(App2.class, args);
	}
	@Bean
	public ServletRegistrationBean geServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}

二、整合filter
1、通过注解扫描完成filter组件注册
1.1、编写filter
/**
 * SpringBoot整合Filter方式一 
 * 	<filter>
 * 		<filter-name>FirstFilter</filter-name>
 * 		<filter-class>com.yunlovec.filter.FirstFilter</filter-class>
 * 	</filter>
 * 	
 * 	<filter-mapping>
 * 		<filter-name>FirstFilter</filter-name>
 * 		<url-pattern>/first</url-pattern>
 * 	</filter-mapping>
 * 	
 */
//@WebFilter(filterName="FirstFilter",urlPatterns= {"*.do","*.jsp"})
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入filter");
		chain.doFilter(request, response);
		System.out.println("离开filter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

1.2、编写启动类
/**
 * SpringBoot整合filter方式一
 *
 */
@SpringBootApplication
@ServletComponentScan
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}

2、通过方法完成filter组建注册
2.1、编写filter
/**
 * SpringBoot整合Filter方式二 
 *
 */
public class SecondFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("进入secondFilter");
		chain.doFilter(request, response);
		System.out.println("离开secondFilter");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}

2.2、编写启动类
/**
 * SpringBoot整合filter方式二 
 *
 */

@SpringBootApplication
public class APP2 {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	/**
	 * 注册servlet
	 * @return
	 */
	@Bean
	public ServletRegistrationBean getsServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	
	/**
	 * 注册Filter
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getFilRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFilter());
//		bean.addUrlPatterns(new String[] {"*.do","*.jsp"});
		bean.addUrlPatterns("/second");
		return bean;
	}
}


