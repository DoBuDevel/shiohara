/*
 * Copyright (C) 2016-2020 Alexandre Oliveira <alexandre.oliveira@viglet.com> 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
/*
 * Copyright (C) 2016-2020 the original author or authors. 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.viglet.shiohara.onstartup.provider.auth;

import com.viglet.shiohara.persistence.model.provider.auth.ShAuthProviderVendor;
import com.viglet.shiohara.persistence.repository.provider.auth.ShAuthProviderVendorRepository;
import com.viglet.shiohara.provider.auth.ShAuthSystemProviderVendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Alexandre Oliveira
 */
@Component
public class ShAuthProviderVendorOnStartup {

	@Autowired
	private ShAuthProviderVendorRepository shAuthProviderVendorRepository;

	public void createDefaultRows() {

		if (shAuthProviderVendorRepository.findAll().isEmpty()) {

			ShAuthProviderVendor shAuthProviderVendor = new ShAuthProviderVendor();
			shAuthProviderVendor.setId("OTDS");
			shAuthProviderVendor.setName(ShAuthSystemProviderVendor.OTDS);
			shAuthProviderVendor.setDescription(ShAuthSystemProviderVendor.OTDS);
			shAuthProviderVendor.setClassName("com.viglet.shiohara.provider.auth.otds.ShOTDSAuthProvider");
			shAuthProviderVendor.setConfigurationPage("template/config/provider/auth/otds/otds-configuration.html");

			shAuthProviderVendorRepository.save(shAuthProviderVendor);
		}

	}
}
