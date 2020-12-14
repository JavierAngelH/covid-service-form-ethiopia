package com.edgedx.covid.views;

import javax.servlet.http.HttpServletResponse;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;

@Tag(Tag.DIV)
public class RouteNotFoundError extends Component
       implements HasErrorParameter<NotFoundException> {

    @Override
    public int setErrorParameter(BeforeEnterEvent event,
          ErrorParameter<NotFoundException> parameter) {
    	event.rerouteTo("");
		return HttpServletResponse.SC_ACCEPTED;
    }
}