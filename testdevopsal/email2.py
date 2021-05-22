import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
mail_content='''
Job 3 for Testing, Build Fail: App is not working.
'''
# The mail address and password
sender_address = 'xyz'
sender_pass = 'xyz'
reciever_address = 'xyz'

# setup the MIME
message = MIMEMultipart()
message['From'] = sender_address
message['To'] = reciever_address
message['Subject'] = 'Testing status' # subject line

# The body and the attachments with the email
message.attach(MIMEText(mail_content, 'plain'))

# Create SMTP session for sending the mail
session = smtplib.SMTP('smtp.gmail.com', 587) # using gmail with its port
session.starttls() # enable security
session.login(sender_address,sender_pass) # login with the mail id and password
text = message.as_string()
session.sendmail(sender_address, reciever_address,text)
session.quit()
print('Mail Send Successfully')
