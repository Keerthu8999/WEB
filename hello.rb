def add (a,b)
	sum = a+b
	puts "#{sum}"
end
def sub (a,b)
	diff = a-b
	puts "#{diff}"
end
def mult (a,b)
	prod = a-b
	puts "#{prod}"
end
def div (a,b)
	quo = a-b
	puts "#{quo}"
end
def squa (a,b)
	blah = a**b
	puts "#{blah}"
end
puts "ITERATIONS"
iterations = gets
iterations = iterations.to_i
while iterations > 0
	puts "Enter 1 - Add , 2 - Sub , 3 - Mul, 4 - Div 5 - Square"
	num = gets
	choice = num.to_i
	puts "Enter number 1"
	id1 = gets
	puts "Enter number 2"
	id2 = gets
	id1 = id1.to_i
	id2 = id2.to_i
	if choice == 1
		add(id1,id2)
	elsif choice == 2
		sub(id1,id2)
	elsif choice == 3
		mult(id1,id2)
	elsif choice == 4
		div(id1,id2)
	elsif choice == 5
		squa(id1,id2)
	else 
		puts "Invalid Choice"
	end
	iterations = iterations-1
end