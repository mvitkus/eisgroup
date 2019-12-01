package lt.vitkusmindaugas.currency.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.vitkusmindaugas.currency.model.Items;
import lt.vitkusmindaugas.currency.repository.CurrencyRepository;
import lt.vitkusmindaugas.currency.service.CurrencyService;

@Service

public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyRepository currencyRepository;

	@Override
	public Items getAlldataFromXML(String startDate, String endDate, String currency) {
		
		return currencyRepository.getAllCurrencyByDates(startDate, endDate, currency);
	}

	@Override
	public Items getCurrencyNames() {
		
		return currencyRepository.getCurrencyNames();
	}

}
