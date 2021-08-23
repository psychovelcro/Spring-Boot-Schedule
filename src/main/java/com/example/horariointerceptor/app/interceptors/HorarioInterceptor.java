package com.example.horariointerceptor.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class HorarioInterceptor implements HandlerInterceptor {

	@Value("${config.horario.apertura}")
	private Integer apertura;
	@Value("${config.horario.cierre}")
	private Integer cierre;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(Calendar.HOUR_OF_DAY);

		if (hora >= apertura && hora < cierre) {
			StringBuilder mensaje = new StringBuilder("Bienvenido al horario de atencion a clientes");
			mensaje.append(", atendemos desde las ");
			mensaje.append(apertura);
			mensaje.append("hrs. ");
			mensaje.append("hasta las ");
			mensaje.append(cierre);
			mensaje.append(". Gracias por su visita. ");

			return true;
		}

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}
