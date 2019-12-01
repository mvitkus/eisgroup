package lt.vitkusmindaugas.currency.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lt.vitkusmindaugas.currency.model.Items;
import lt.vitkusmindaugas.currency.service.CurrencyService;

@Controller
@RequestMapping(value = "/")
public class CurrencyController {

	@Autowired
	CurrencyService currencyService;

	@RequestMapping("/")
	public ModelAndView duomenuIvedimas() {
		ModelAndView model = new ModelAndView();
		Items valiutosKodai = currencyService.getCurrencyNames();
		valiutosKodai.getItem().remove(0);
		model.setViewName("hello");
		model.addObject("valiutos", valiutosKodai);
		return model;
	}

	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	public ModelAndView list(String currency, String startdate, String enddate, HttpSession session) {
		// ModelAndView model = new ModelAndView("page");
		ModelAndView model = new ModelAndView();
		Items itemai = currencyService.getAlldataFromXML(startdate, enddate, currency);
		Items valiutosKodai = currencyService.getCurrencyNames();
		valiutosKodai.getItem().remove(0);
		itemai.getItem().remove(0);
		if (itemai.getItem().size() > 1) {
			String pirmas = itemai.getItem().get(0).getSantykis();
			String paskutinis = itemai.getItem().get(itemai.getItem().size() - 1).getSantykis();
			String pokytis = String.format("%.4f",
					(Double.parseDouble(pirmas.replace(',', '.')) - Double.parseDouble(paskutinis.replace(',', '.'))));
			model.setViewName("page");
			model.addObject("valiutos", valiutosKodai);
			model.addObject("items", itemai);
			model.addObject("pirmas", pirmas);
			model.addObject("paskutinis", paskutinis);
			model.addObject("skaicius", pokytis);

		} else if (itemai.getItem().size() == 1) {
			model.setViewName("page");
			model.addObject("items", itemai);
			model.addObject("valiutos", valiutosKodai);
			String pirmas = itemai.getItem().get(0).getSantykis();
			String paskutinis = itemai.getItem().get(0).getSantykis();
			String pokytis = String.format("%.4f",
					(Double.parseDouble(pirmas.replace(',', '.')) - Double.parseDouble(paskutinis.replace(',', '.'))));
			model.addObject("pirmas", pirmas);
			model.addObject("paskutinis", paskutinis);
			model.addObject("skaicius", pokytis);

		} else {
			model.setViewName("notfound");
			model.addObject("valiutos", valiutosKodai);
		}
		return model;

	}

}
