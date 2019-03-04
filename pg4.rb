require 'nokogiri'
doc = Nokogiri::XML(File.open("blah.xml"))
doc.xpath('//student/marks').each do
 |char_element|
 puts char_element.text
 end