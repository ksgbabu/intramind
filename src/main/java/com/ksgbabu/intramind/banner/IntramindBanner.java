package com.ksgbabu.intramind.banner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.BannerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by gireeshbabu on 22/02/16.
 */
@Component
@Order(value = 1)
public class IntramindBanner implements BannerProvider {

    Logger logger = LoggerFactory.getLogger(IntramindBanner.class);

    @Override
    public String getBanner() {

        logger.debug("Banner is getting loaded:");
        Path path = Paths.get("./banner.txt");
        byte[] fileArray = new byte[0];
        try {
            fileArray = Files.readAllBytes(path);
        } catch (IOException e) {
            logger.info("The file "+path.toString()+" does not exit.");
        }
        String fileString = new String(fileArray);
        return fileString;
    }

    @Override
    public String getVersion() {
        return "Version 1.0";
    }

    @Override
    public String getWelcomeMessage() {
        return "Your favorite working environment";
    }

    @Override
    public String getProviderName() {
        return "ksgbabu.com";
    }
}
