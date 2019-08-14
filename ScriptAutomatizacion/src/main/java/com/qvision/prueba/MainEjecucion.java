package com.qvision.prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainEjecucion {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver pepito = new ChromeDriver();
		pepito.get("http://developsupport.com/qIntranet/login/index.php");

		WebElement txtUsuario = pepito.findElement(By.id("username"));
		txtUsuario.sendKeys("jrubio");
		Thread.sleep(2000);
		WebElement txtPassword = pepito.findElement(By.id("password"));
		txtPassword.sendKeys("Admin@123");
		Thread.sleep(2000);
		WebElement btnLogin = pepito.findElement(By.id("loginbtn"));
		btnLogin.click();
		try {
			WebElement lblMensajeError = pepito
					.findElement(By.xpath("//*[@id='region-main']/div[2]/div/div/div/div[1]/span"));
			if (lblMensajeError.isDisplayed()) {
				System.out.println("Fallo de inicio de sesión.");
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		pepito.quit();
	}

}
