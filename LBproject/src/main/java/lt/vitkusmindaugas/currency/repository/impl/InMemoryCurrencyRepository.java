package lt.vitkusmindaugas.currency.repository.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import lt.vitkusmindaugas.currency.model.Items;
import lt.vitkusmindaugas.currency.repository.CurrencyRepository;

@Repository
public class InMemoryCurrencyRepository implements CurrencyRepository {

	@Override
	public Items getAllCurrencyByDates(String startDate, String endDate, String currency) {

		Items items = new Items();
		String link = "https://www.lb.lt/lt/currency/exportlist/?xml=1&currency=" + currency
				+ "&ff=1&amp;class=Eu&type=day&date_from_day=" + startDate + "&date_to_day=" + endDate;
		URL url = null;
		try {
			url = new URL(link);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Items.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			items = (Items) jaxbUnmarshaller.unmarshal(url);

		} catch (JAXBException e) {
			e.printStackTrace();

		}

		return items;
	}

	@Override
	public Items getCurrencyNames() {
		Items items = new Items();
		String link = "https://www.lb.lt/lt/currency/daylyexport/?xml=1&class=Eu&type=day&date_day=2019-11-29";
		URL url = null;
		try {
			url = new URL(link);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Items.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			items = (Items) jaxbUnmarshaller.unmarshal(url);

		} catch (JAXBException e) {
			e.printStackTrace();

		}

		return items;
	}

}
