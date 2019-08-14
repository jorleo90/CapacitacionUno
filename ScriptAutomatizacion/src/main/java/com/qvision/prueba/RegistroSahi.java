package com.qvision.prueba;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistroSahi {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://sahitest.com/demo/training/login.htm");
		
		//Objetos
		WebElement lnkRegistro = driver.findElement(By.xpath("//a"));
		lnkRegistro.click();		
		WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Usuario 1");		
		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("Admin123");		
		WebElement txtRepeatPassword = driver.findElement(By.name("password2"));
		txtRepeatPassword.sendKeys("Admin123");		
		List<WebElement> rbdGenero = driver.findElements(By.name("gender"));
		for (WebElement genero : rbdGenero) {
			if(genero.getAttribute("value").equals("F")) {
				genero.click();
			}
		}		
		Thread.sleep(2000);		
		WebElement txtDireccion = driver.findElement(By.name("address"));
		txtDireccion.sendKeys("Calle falsa 123");		
		WebElement txtDireccionEnvio = driver.findElement(By.name("billaddress"));
		txtDireccionEnvio.sendKeys("Calle falsa 123");
		WebElement cmbEstadoPre = driver.findElement(By.name("state"));
		Select cmbEstado = new Select(cmbEstadoPre);
		cmbEstado.selectByVisibleText("Kerala");		
		Thread.sleep(2000);		
		WebElement chkAcepto = driver.findElement(By.name("agree"));
		chkAcepto.click();		
		WebElement btnRegistrar = driver.findElement(By.xpath("/html/body/center/div/form/input[2]"));
		btnRegistrar.click();		
		Thread.sleep(2000);		
		Alert alerta = driver.switchTo().alert();
		String msjAlerta = alerta.getText();
		System.out.println(msjAlerta);		
		if(msjAlerta.equals("Registered Successfully")) {
			System.out.println("Registro Exitoso!!");
		}
		alerta.accept();
		Thread.sleep(2000);
		driver.quit();
	}

}
