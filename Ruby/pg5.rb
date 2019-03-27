begin
file = File.open("blah.xml")
   while line = file.gets
      puts line
   end
ensure
   file.close
end