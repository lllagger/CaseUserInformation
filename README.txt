# CaseUserInformation

Uygulamayı başlattıktan sonra, http://localhost:8080/v2/api-docs/ adresine gidilerek JSON tabanlı Swagger kodu kopyalanır.

daha sonra CMD üzerinden Chrome için; 
        C:\Program Files\Google\Chrome\Application> dosya yoluna gidliler ve Chrome uygulaması web-security kapatılarak çalıştırılır.
        chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security
        
        Not: CMD üzerinde kodun tamamı şu şekilde gözükecek= C:\Program Files\Google\Chrome\Application>chrome.exe --user-data-dir="C:/Chrome dev session" --disable-web-security

CMD çalıştırıldıktan sonra açılan Google Chrome ile https://editor-next.swagger.io/ adresine gidilir.

http://localhost:8080/v2/api-docs adresinden kopyaladığımız JSON tabanlı kod https://editor-next.swagger.io/ adresinde ekranın sol tarafında bulunan Editör'e yapıştırılır.

Login API si ile uygulamaya login olunur ve kalan API ler denenir.


http://localhost:8080/h2-console/ urlsne gidilir

username = sa
userpassword =

url = jdbc:h2:mem:userinformation

verilerek içeriye girilebilir.
