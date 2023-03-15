Send an Post API request into localhost:8080/pull-uri with accept as application/xml and request body contain xml below

<DocType>pdf</DocType> //Document type
<DigiLockerId>3434234</DigiLockerId > //Unique 36 character DigiLocker Id
<UID>234324324</UID> //Aadhaar number (Optional)
<FullName> Cebil</FullName> //Name as on Aadhaar (Optional)
<DOB>01/01/2023</DOB> //Date of birth as on Aadhaar (Optional)
<Photo>sfsdfsfsf</Photo> //Base 64 encoded JPEG photograph as on Aadhaar (Optional)
<PPONO>232424</PPONO> //User defined field
<USRDOB>01/01/2023</USRDOB> //User defined field
</DocDetails>
</PullURIRequest>


Recieved output from the response body as below xml file

<?xml version='1.0' encoding='UTF-8'?>
<PullURIResponse xmlns:ns2="http://tempuri.org/">
    <ResponseStatus Status="1" ts="1678875640887" txn="8710">1</ResponseStatus>
    <DocDetails>
        <IssuedTo>
            <Persons>
                <Person name="anand" dob="2023-01-01" gender="male" phone="8239284920">
                    <Photo format="jpeg">no photo available</Photo>
                </Person>
            </Persons>
        </IssuedTo>
        <URI>issuer-id-doc-type-232424</URI>
        <DocContent>Ym1WM0lHUmxiVzhnWm1sc1pTQm1iM0lnZEdobElHVnRjR3h2ZVdWbElHUmhkR0VnYzJWMENnPT0=</DocContent>
    </DocDetails>
</PullURIResponse>

