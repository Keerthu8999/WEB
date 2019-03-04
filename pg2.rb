numbers = [1,3,5,8,10,14]

puts "Squares - each function "
square = numbers.each{|x| x**2}
p square
puts "\n"

puts "Detecting the first Double digit - detect function"
digit = numbers.detect {|x| x > 9}
print digit
puts "\n \n"

puts "Even Numbers -  select function"
evens = numbers.select{|x| x % 2 == 0}
p evens
puts "\n"

puts "Powers - collect function"
powers = numbers.collect{|x| x**3}
p powers
puts "\n"

puts "Cumulating - inject function"
sum = numbers.inject(0){|a,n| a+n}
p sum
puts "\n"

